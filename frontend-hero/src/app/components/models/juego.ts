import { Mazo } from './mazo';
import { Jugador } from './jugador';
export class Juego {
    id?: string;
    ronda: string;
    jugadores: Jugador[];

    constructor(ronda: string, jugadores:Jugador[]){
        this.ronda = ronda;
        this.jugadores = jugadores;

    }
}