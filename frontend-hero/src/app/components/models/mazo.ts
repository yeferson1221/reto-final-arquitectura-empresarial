export class Mazo {
    id?: string;
    cartas: [];
    cantidad: number;

    constructor(cartas: [], cantidad: number){
        this.cartas = cartas;
        this.cantidad = cantidad;

    }
}