
export class Carta {
    id?: string;
    nombre: string;
    valor: number;
    uri: string;
    esOculta: boolean
    constructor(nombre: string, valor: number, uri: string, esOculta:boolean){
        this.nombre = nombre;
        this.valor = valor;
        this.uri = uri;
        this.esOculta = esOculta;


    }
}