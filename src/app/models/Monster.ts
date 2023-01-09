export class Monster {
    private _id!: number;
    private _name!: string;
    private _description!: string;
    private _price!: number;
    private _category!: string;
    private _stock!: number;
    private _urlImage!: string;
    
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get price(): number {
        return this._price;
    }
    public set price(value: number) {
        this._price = value;
    }
    public get category(): string {
        return this._category;
    }
    public set category(value: string) {
        this._category = value;
    }
    public get stock(): number {
        return this._stock;
    }
    public set stock(value: number) {
        this._stock = value;
    }
    public get urlImage(): string {
        return this._urlImage;
    }
    public set urlImage(value: string) {
        this._urlImage = value;
    }
}