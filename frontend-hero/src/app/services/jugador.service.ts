import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Jugador } from '../components/models/jugador';


@Injectable({
  providedIn: 'root'
}
)
export class JugadorService {

  url = '/api/jugador/';
 
  constructor(private http: HttpClient) { }

  guardarJugador(jugador: Jugador): Observable<any> {
    return this.http.post(this.url, jugador);
  }

  obtenerJugadorId(id: string): Observable<any> {
    return this.http.get(this.url + id);
  }

  optenerJugador(): Observable<any> {
    return this.http.get(this.url);
  }

}
