import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
}
)
export class JuegoService {

  url = '/api/juego/';
 
  constructor(private http: HttpClient) { }

  optenerJuego(): Observable<any> {
    return this.http.get(this.url);
  }

}