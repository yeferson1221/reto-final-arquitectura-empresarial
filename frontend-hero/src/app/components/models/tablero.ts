export class Tablero {
    id?: string;
    idjugador: string;
    idcarta: string;
    tiempo?: number;
    uri:string;
    ronda: string;
    idJuego: string;

    constructor(idjugador:string, idcarta: string, tiempo: number, uri: string,  ronda: string, idJuego: string){
        this.idjugador = idjugador;
        this.idcarta = idcarta;
        this.tiempo = tiempo;
        this.uri = uri;
        this.ronda = ronda;
        this.idJuego = idJuego;

    }
}