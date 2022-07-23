import { Component, OnInit } from '@angular/core';
import { Jugador } from '../models/jugador';
import { Mazo } from '../models/mazo';
import { JugadorService } from 'src/app/services/jugador.service';
import { MazoService } from 'src/app/services/mazo.service';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})
export class JuegoComponent implements OnInit {
      jugadores: Jugador[] = [];
      mazo: Mazo[] = [];
  constructor(
    private jugadorService: JugadorService,
    private mazoService: MazoService,
  ) { }

  ngOnInit(): void {
     this.obtenerJugadorId('62db0581a608805a436789a3')
  }

  obtenerJugadorId(id:any) {
    this.jugadorService.obtenerJugadorId(id).subscribe(data => {
      this.jugadores.push(data);
      console.log(this.jugadores)
    }, error => {
      console.log(error);
    
    })
  }

  obtenerMazo(){
    this.mazoService.optenerMazo().subscribe(data => {
      this.mazo.push(data);
      console.log(this.mazo)
    }, error => {
      console.log(error);
    
    })
  }

}
