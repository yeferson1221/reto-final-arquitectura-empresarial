import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
}
)
export class MazoService {

  url = '/api/mazo/';
 
  constructor(private http: HttpClient) { }

  optenerMazo(): Observable<any> {
    return this.http.get(this.url);
  }

}
