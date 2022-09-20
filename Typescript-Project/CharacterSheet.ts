import { CharacterClass } from "./CharacterClass";
import { Item } from "./Item";
import { ItemType } from "./Item";
export class CharacterSheet {
  name: String;
  level: Number;
  str: Number;
  dex: Number;
  con: Number;
  wis: Number;
  int: Number;
  characterClass: CharacterClass;
  inventory: Array<Item>;
  health: Number;
  AC: Number;
  proficiencyBonus: Number;

  constructor(
    name: String,
    str: Number,
    dex: Number,
    con: Number,
    wis: Number,
    int: Number,
    level: Number,
    characterClass: CharacterClass
  ) {
    this.name = name;
    this.str = str;
    this.dex = dex;
    this.con = con;
    this.wis = wis;
    this.int = int;
    this.level = level;
    this.characterClass = characterClass;
    this.health =
      Number(this.characterClass.rollDice()) * Number(this.level) +
      Number(this.con);
    this.AC = Number(10) + Number(this.dex);
    this.proficiencyBonus = 1 + Number(Math.floor(Number(this.level) / 4));
    this.inventory = new Array<Item>();
  }

  getAttackItems = function (): Array<Item> {
    return this.inventory.filter((e) => e.type == ItemType.Weapon);
  };

  addItem = function (item: Item): void {
    this.inventory.push(item);
  };
  getHealth = function (): Number {
    return this.health;
  };
  takeDamage = function (damage: Number): void {
    this.health -= Number(damage);
    this.health = Math.max(this.health, 0);
  };
  getStr = function (): Number {
    return this.str;
  };
  getDex = function (): Number {
    return this.dex;
  };
  getProficiency = function (): Number {
    return this.proficiencyBonus;
  };
  getName = function (): String {
    return this.name;
  };
  getAttack = function (command: String): Number {
    for (let item of this.inventory) {
      if (item.name == command) return item.getAttack();
    }
    return 0;
  };
}
