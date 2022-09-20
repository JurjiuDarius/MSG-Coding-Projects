"use strict";
exports.__esModule = true;
exports.CharacterSheet = void 0;
var Item_1 = require("./Item");
var CharacterSheet = /** @class */ (function () {
    function CharacterSheet(name, str, dex, con, wis, int, level, characterClass) {
        this.getAttackItems = function () {
            return this.inventory.filter(function (e) { return e.type == Item_1.ItemType.Weapon; });
        };
        this.addItem = function (item) {
            this.inventory.push(item);
        };
        this.getHealth = function () {
            return this.health;
        };
        this.takeDamage = function (damage) {
            this.health -= Number(damage);
            this.health = Math.max(this.health, 0);
        };
        this.getStr = function () {
            return this.str;
        };
        this.getDex = function () {
            return this.dex;
        };
        this.getProficiency = function () {
            return this.proficiencyBonus;
        };
        this.getName = function () {
            return this.name;
        };
        this.getAttack = function (command) {
            for (var _i = 0, _a = this.inventory; _i < _a.length; _i++) {
                var item = _a[_i];
                if (item.name == command)
                    return item.getAttack();
            }
            return 0;
        };
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
        this.inventory = new Array();
    }
    return CharacterSheet;
}());
exports.CharacterSheet = CharacterSheet;
