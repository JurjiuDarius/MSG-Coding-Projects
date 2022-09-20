"use strict";
exports.__esModule = true;
exports.CharacterClass = exports.DiceClass = void 0;
var DiceClass;
(function (DiceClass) {
    DiceClass[DiceClass["D6"] = 0] = "D6";
    DiceClass[DiceClass["D8"] = 1] = "D8";
    DiceClass[DiceClass["D10"] = 2] = "D10";
    DiceClass[DiceClass["D12"] = 3] = "D12";
})(DiceClass = exports.DiceClass || (exports.DiceClass = {}));
var CharacterClass = /** @class */ (function () {
    function CharacterClass(name, classLevel, diceClass) {
        this.rollDice = function () {
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
        this.name = name;
        this.classLevel = classLevel;
        this.diceClass = diceClass;
    }
    return CharacterClass;
}());
exports.CharacterClass = CharacterClass;
