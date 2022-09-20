"use strict";
exports.__esModule = true;
var CharacterSheet_1 = require("./CharacterSheet");
var CharacterClass_1 = require("./CharacterClass");
var Item_1 = require("./Item");
var CharacterClass_2 = require("./CharacterClass");
var prompt = require("prompt-sync")();
var Actions;
(function (Actions) {
    Actions["ATTACK"] = "Attack";
    Actions["END_TURN"] = "End turn";
})(Actions || (Actions = {}));
var roll20Dice = function () {
    return Math.floor(Math.random() * 19 + 1);
};
var randomStat = function () {
    return Math.floor(Math.random() * 4 + 1);
};
var playTurn = function (character, opponent) {
    var availableActions = Object.values(Actions);
    console.log("Current character: " + character.getName());
    while (true) {
        console.log("Available actions: " + availableActions);
        var action = prompt();
        switch (action) {
            case "End turn": {
                console.log("Your turn has ended");
                return;
            }
            case "Attack": {
                if (!availableActions.includes(Actions.ATTACK)) {
                    console.log("You were too tired to attack, tripped and fell over. Take 3 damage");
                }
                else {
                    availableActions.splice(availableActions.indexOf(Actions.ATTACK), 1);
                    console.log("Available items: " + Object.values(character.getAttackItems()));
                    var action_1 = prompt("Type Use + <Item_name>");
                    var attack = character.getAttack(action_1.split(" ")[1]);
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
var Barbarian = new CharacterClass_2.CharacterClass("Barbarian", randomStat(), CharacterClass_1.DiceClass.D6);
var Fighter = new CharacterClass_2.CharacterClass("Fighter", randomStat(), CharacterClass_1.DiceClass.D10);
var Dekebalus = new CharacterSheet_1.CharacterSheet("Dekebalus", randomStat(), randomStat(), randomStat(), randomStat(), randomStat(), randomStat(), Barbarian);
var Constantine = new CharacterSheet_1.CharacterSheet("Constantine", randomStat(), randomStat(), randomStat(), randomStat(), randomStat(), randomStat(), Fighter);
var axe = new Item_1.Item("Axe", Item_1.ItemType.Weapon, Dekebalus);
var sword = new Item_1.Item("Sword", Item_1.ItemType.Weapon, Constantine);
Dekebalus.addItem(axe);
Constantine.addItem(sword);
var answer = prompt("Start combat? Type yes or no.");
if (answer == "yes") {
    console.log("Hatz john");
    var currentCharacter = void 0, currentOpponent = void 0;
    while (Dekebalus.getHealth() > 0 && Constantine.getHealth() > 0) {
        console.log("Rolling inititive...");
        var initiativeDekebalus = roll20Dice(), initiativeConstantine = roll20Dice();
        if (initiativeDekebalus > initiativeConstantine) {
            currentCharacter = Dekebalus;
            currentOpponent = Constantine;
        }
        else {
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
    }
    else {
        console.log("Dekebalus has won!");
    }
}
else {
    console.log("Coward...");
}
