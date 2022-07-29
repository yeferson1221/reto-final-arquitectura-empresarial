import { Carta } from './carta';
export class Mazo {
    id?: string;
    baraja: Carta[];
    cantidad: number;

    constructor(baraja: Carta[], cantidad: number){
        this.baraja = baraja;
        this.cantidad = cantidad;

    }
}