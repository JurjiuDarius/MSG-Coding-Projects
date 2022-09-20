"use strict";
exports.__esModule = true;
exports.Item = exports.ItemType = void 0;
var ItemType;
(function (ItemType) {
    ItemType["Armor"] = "Armor";
    ItemType["Weapon"] = "Weapon";
})(ItemType = exports.ItemType || (exports.ItemType = {}));
var Item = /** @class */ (function () {
    function Item(name, type, owner) {
        this.getArmor = function () {
            return this.owner.getDex() + 13;
        };
        this.getAttack = function () {
            return (this.owner.characterClass.rollDice() +
                this.owner.getStr() +
                this.owner.getProficiency());
        };
        this.getDamage = function () {
            return this.owner.characterClass.rollDice() + this.owner.getStr();
        };
        this.name = name;
        this.type = type;
        this.owner = owner;
    }
    Item.prototype.toString = function () {
        return this.name;
    };
    return Item;
}());
exports.Item = Item;
