import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tablero } from '../components/models/tablero';


@Injectable({
  providedIn: 'root'
}
)
export class TableroService {
 

  url = '/api/tablero/';
 
  constructor(private http: HttpClient) { }


  optenerTablero(): Observable<any>{
    return this.http.get(this.url)
  }

  ponerApuesta(tablero: Tablero): Observable<any> {
    return this.http.post(this.url, tablero);
  }

  optenerGanadorRonda(id: string, id2: string): Observable<any>{
    return this.http.get(this.url + id + id2);
  }

}
