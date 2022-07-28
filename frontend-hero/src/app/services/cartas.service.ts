import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
}
)
export class CartaService {

  url = '/api/carta/';
 
  constructor(private http: HttpClient) { }

  optenerCarta(): Observable<any> {
    return this.http.get(this.url);
  }

}