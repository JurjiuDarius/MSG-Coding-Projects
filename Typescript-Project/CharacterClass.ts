export enum DiceClass {
  D6,
  D8,
  D10,
  D12,
}

export class CharacterClass {
  name: String;
  classLevel: Number;
  diceClass: DiceClass;

  constructor(name: String, classLevel: Number, diceClass: DiceClass) {
    this.name = name;
    this.classLevel = classLevel;
    this.diceClass = diceClass;
  }

  rollDice = function (): Number {
    switch (this.diceClass) {
      case DiceClass.D6:
        return Math.floor(Math.random() * 5 + 1);
      case DiceClass.D8:
        return Math.floor(Math.random() * 7 + 1);
      case DiceClass.D10:
        return Math.floor(Math.random() * 9 + 1);
      case DiceClass.D12:
        return Math.floor(Math.random() * 11 + 1);
      default:
        return 1;
    }
  };
}
