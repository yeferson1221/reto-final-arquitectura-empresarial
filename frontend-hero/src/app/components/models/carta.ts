
export class Carta {
    id?: string;
    nombre: string;
    valor: number;
    uri: string;
    esOculta: boolean
    constructor(id: string, nombre: string, valor: number, uri: string, esOculta:boolean){
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.uri = uri;
        this.esOculta = esOculta;

    }
}