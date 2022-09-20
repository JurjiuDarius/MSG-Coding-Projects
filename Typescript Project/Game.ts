import { CharacterSheet } from "./CharacterSheet";
import { DiceClass } from "./CharacterClass";
import { Item, ItemType } from "./Item";
import { CharacterClass } from "./CharacterClass";
const prompt = require("prompt-sync")();
enum Actions {
  ATTACK = "Attack",
  END_TURN = "End turn",
}
let roll20Dice = function (): Number {
  return Math.floor(Math.random() * 19 + 1);
};
let randomStat = function (): Number {
  return Math.floor(Math.random() * 4 + 1);
};
let playTurn = function (
  character: CharacterSheet,
  opponent: CharacterSheet
): void {
  let availableActions = Object.values(Actions);
  console.log("Current character: " + character.getName());
  while (true) {
    console.log("Available actions: " + availableActions);
    let action = prompt();

    switch (action) {
      case "End turn": {
        console.log("Your turn has ended");
        return;
      }
      case "Attack": {
        if (!availableActions.includes(Actions.ATTACK)) {
          console.log(
            "You were too tired to attack, tripped and fell over. Take 3 damage"
          );
        } else {
          availableActions.splice(availableActions.indexOf(Actions.ATTACK), 1);
          console.log(
            "Available items: " + Object.values(character.getAttackItems())
          );
          let action: String = prompt("Type Use + <Item_name>");
          let attack = character.getAttack(action.split(" ")[1]);
          console.log("You have dealt " + attack + " damage.");
          opponent.takeDamage(attack);
          console.log("Opponent now has " + opponent.getHealth() + " health.");
        }
        break;
      }
      default: {
        console.log("Clumsy typing won't do. Your turn has ended");
        return;
      }
    }
  }
};

let Barbarian: CharacterClass = new CharacterClass(
  "Barbarian",
  randomStat(),
  DiceClass.D6
);
let Fighter: CharacterClass = new CharacterClass(
  "Fighter",
  randomStat(),
  DiceClass.D10
);

let Dekebalus = new CharacterSheet(
  "Dekebalus",
  randomStat(),
  randomStat(),
  randomStat(),
  randomStat(),
  randomStat(),
  randomStat(),
  Barbarian
);
let Constantine = new CharacterSheet(
  "Constantine",
  randomStat(),
  randomStat(),
  randomStat(),
  randomStat(),
  randomStat(),
  randomStat(),
  Fighter
);
var axe = new Item("Axe", ItemType.Weapon, Dekebalus);
var sword = new Item("Sword", ItemType.Weapon, Constantine);
Dekebalus.addItem(axe);
Constantine.addItem(sword);
let answer = prompt("Start combat? Type yes or no.");
if (answer == "yes") {
  console.log("Hatz john");
  let currentCharacter, currentOpponent: CharacterSheet;

  while (Dekebalus.getHealth() > 0 && Constantine.getHealth() > 0) {
    console.log("Rolling inititive...");
    let initiativeDekebalus = roll20Dice(),
      initiativeConstantine = roll20Dice();

    if (initiativeDekebalus > initiativeConstantine) {
      currentCharacter = Dekebalus;
      currentOpponent = Constantine;
    } else {
      currentCharacter = Constantine;
      currentOpponent = Dekebalus;
    }
    playTurn(currentCharacter, currentOpponent);
    if (currentOpponent.getHealth() > 0 && currentCharacter.getHealth() > 0) {
      playTurn(currentOpponent, currentCharacter);
    }
  }
  if (Constantine.getHealth() > 0) {
    console.log("Constantine has won!");
  } else {
    console.log("Dekebalus has won!");
  }
} else {
  console.log("Coward...");
}
