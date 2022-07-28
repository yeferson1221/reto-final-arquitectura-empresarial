
import { Jugador } from './jugador';
export class Juego {
    id?: string;
    ronda: string;
    jugadores: Jugador[];

    constructor(id: string, ronda: string, jugadores:Jugador[]){
        this.id = id;
        this.ronda = ronda;
        this.jugadores = jugadores;
    }
}