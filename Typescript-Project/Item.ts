import { CharacterSheet } from "./CharacterSheet";

export enum ItemType {
  Armor = "Armor",
  Weapon = "Weapon",
}
export class Item {
  name: String;
  type: ItemType;
  owner: CharacterSheet;

  constructor(name: String, type: ItemType, owner: CharacterSheet) {
    this.name = name;
    this.type = type;
    this.owner = owner;
  }

  getArmor = function (): Number {
    return this.owner.getDex() + 13;
  };

  getAttack = function (): Number {
    return (
      this.owner.characterClass.rollDice() +
      this.owner.getStr() +
      this.owner.getProficiency()
    );
  };
  toString() {
    return this.name;
  }
}
