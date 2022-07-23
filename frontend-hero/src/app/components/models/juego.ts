export class Juego {
    id?: string;
    ronda: string;
    jugadores: [];

    constructor(ronda: string, jugadores: []){
        this.ronda = ronda;
        this.jugadores = jugadores;

    }
}