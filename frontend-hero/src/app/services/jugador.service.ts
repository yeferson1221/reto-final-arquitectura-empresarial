import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Jugador } from '../components/models/jugador';




@Injectable({
  providedIn: 'root'
}
)
export class JugadorService {

  url = '/api/jugador';
  url2 = '/api/usecase/pet';
  url3 = '/api/usecase/';
  url4 = '/api/usecase/nombre/';



  constructor(private http: HttpClient) { }

  getJugador(): Observable<any> {
    return this.http.get(this.url);
  }

  eliminarJugador(id: string): Observable<any> {
    return this.http.delete(this.url + id);
  }

  guardarJugador(jugador: Jugador): Observable<any> {
    return this.http.post(this.url, jugador);
  }

  obtenerJugador(id: string): Observable<any> {
    return this.http.get(this.url3 + id);
  }
  editarJugador(id: string, pet: Jugador): Observable<any> {
    return this.http.post(this.url + id, pet);
  }

  buscarJugadorNombre(name: string): Observable<any> {
    return this.http.get(this.url4 + name)
  }

}
