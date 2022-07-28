import { Component, OnInit } from '@angular/core';
import { Tablero } from '../models/tablero';
import { TableroService } from 'src/app/services/tablero.service';


@Component({
  selector: 'app-tablero',
  templateUrl: './tablero.component.html',
  styleUrls: ['./tablero.component.css']
})
export class TableroComponent implements OnInit {
  tableros: Tablero[] = [];
  tables: [] = [];
  
  constructor(
    private tableroService: TableroService,

  ) { }

  ngOnInit(): void {
    this.obtenerTablero()
  
  }


  obtenerTablero(){
    this.tableroService.optenerTablero().subscribe(data => {
      this.tableros = data;
       
      console.log(this.tableros+" este es el tablero")
    }, error => {
      console.log(error);
    
    })
  }

}
