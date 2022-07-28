import { Mazo } from './mazo';

export class Jugador {
    id?: string;
    nombre: string;
    mazo: Mazo[];
    turno: string;
    puntaje: number;

    constructor(id:string, nombre: string, mazo: [], turno: string, puntaje: number ){
        this.id = id;
        this.nombre = nombre;
        this.mazo = mazo;
        this.turno = turno;
        this.puntaje = puntaje;

    }
}