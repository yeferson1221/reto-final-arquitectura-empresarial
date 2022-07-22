export class Jugador {
    id?: string;
    nombre: string;
    mazo: string;
    turno: string;
    puntaje: number;

    constructor(nombre: string, mazo: string, turno: string, puntaje: number ){
        this.nombre = nombre;
        this.mazo = mazo;
        this.turno = turno;
        this.puntaje = puntaje;

    }
}