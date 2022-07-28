import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
}
)
export class JuegoService {

  url = '/api/juego/';
  ur2 = '/api/juego/lista';
 
  constructor(private http: HttpClient) { }

  optenerJuego(): Observable<any> {
    return this.http.get(this.url);
  }

  listarJuego(): Observable<any> {
      return this.http.get(this.ur2);
  }

}