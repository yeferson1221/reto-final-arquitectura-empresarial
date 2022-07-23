import { Component, OnInit } from '@angular/core';
import { Jugador } from '../models/jugador';
import { Mazo } from '../models/mazo';
import { JugadorService } from 'src/app/services/jugador.service';
import { MazoService } from 'src/app/services/mazo.service';
import { JuegoService } from 'src/app/services/juego.service';
import { Juego } from '../models/juego';
import { Carta } from '../models/carta';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})
export class JuegoComponent implements OnInit {
      jugadores: Jugador[] = [];
      mazos: Mazo[] = [];
      juegos: Juego[] =[];
      cartas:  Carta[]= [];
      barajas: any[] =[];
      console = console;
  constructor(
    private jugadorService: JugadorService,
    private mazoService: MazoService,
    private juegoService: JuegoService,
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
      this.mazos.push(data);

      this.mazos.forEach((mazo)=>{
        
        mazo.baraja.forEach((mazo)=>{
           this.barajas.push(mazo)
          //var mazoJugador = jugador.mazo
          
         console.log(mazo.valor)



        })
      
      }
          
        )

      console.log(this.mazos)
    }, error => {
      console.log(error);
    
    })
  }
  obtenerJuego(){
    this.juegoService.optenerJuego().subscribe(data => {
      this.juegos.push(data);
      this.juegos.forEach((juego)=>{
        
        juego.jugadores.forEach((jugador)=>{
           
          //var mazoJugador = jugador.mazo
          
         console.log(jugador.nombre)



        })
      
      }
          
        )
      
      console.log(this.juegos)
    }, error => {
      console.log(error);
    
    })
  }

}
