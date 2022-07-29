import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { Router } from '@angular/router';
import { Jugador } from '../models/jugador';
import { Mazo } from '../models/mazo';
import { JugadorService } from 'src/app/services/jugador.service';
import { MazoService } from 'src/app/services/mazo.service';
import { JuegoService } from 'src/app/services/juego.service';
import { Juego } from '../models/juego';
import { Carta } from '../models/carta';
import { Tablero } from '../models/tablero';
import { TableroService } from 'src/app/services/tablero.service';

@Component({
  selector: 'app-juego-sala',
  templateUrl: './juego-sala.component.html',
  styleUrls: ['./juego-sala.component.css']
})
export class JuegoSalaComponent implements OnInit {
  jugadores: Jugador[] = [];
  tableros: Tablero[] = [];
  tables: [] = [];
  juegos: Juego[] =[];
  juegosid: Juego[] =[];
  barajas: Carta[] =[];


  idjugador:any;
  idjuegoId:any;
  idcarta:any;
  idjuego:any;
  uricarta:any;
  rondaTablero:any;
  idJuegoGana:any;
  dataUser: any;
  console = console;
  id: string | null;
constructor(
private jugadorService: JugadorService,
private tableroService: TableroService,
private mazoService: MazoService,
private juegoSerivice: JuegoService,
private aRouter: ActivatedRoute,
private afAuth: AngularFireAuth,
private router: Router
) {  
  this.id = this.aRouter.snapshot.paramMap.get('id');
}

ngOnInit(): void {
 //this.obtenerJugadorId('62de03765ce3215fc4a10b02')
 //this.optenerJugador()

    this.afAuth.currentUser.then(user => {
  if(user && user.emailVerified) {
    this.dataUser = user;
    console.log(user)
  } else {
    this.router.navigate(['/login']);
  }
})
//this.obtenerTablero()
this.listarJuego()
//this.obtenerJuegoId()
}

logOut() {
this.afAuth.signOut().then(() => this.router.navigate(['/login']));
}


listarJuego() {
    
  this.juegoSerivice.listarJuego().subscribe(data => {
    this.juegos = data;
    this.juegos.forEach(juego=>{this.idjuegoId = juego.id})
    this.console.log(this.idjuegoId+"este es el id")
    console.log(this.juegos)
  }, error => {
    console.log(error);

  })
}


// obtenerJuegoId(){

//   this.juegoSerivice.listarJuedoId(this.idjuegoId).subscribe(data => {
//     this.juegos.push(data);

//     console.log(this.juegosid+' listar por id'+this.idjuegoId)

//   }, error => {
//     console.log(error);
  
//   })
// }

optenerJugador() {
  this.juegos.forEach(juego=>{
    juego.jugadores.forEach(jugador=>{
      this.jugadores.push(jugador)
     
      if(jugador.nombre === this.dataUser?.email){
        jugador.mazo.baraja.forEach(baraja =>{
          this.barajas.push(baraja)
        } )
      }
    })
  })
   
}
// obtenerJugadorId(id:any) {
//   this.jugadorService.obtenerJugadorId(id).subscribe(data => {
//     this.jugadores.forEach((jugador)=>{
//       console.log(jugador.nombre+"ddddddddddd")
//     })
//     this.jugadores.push(data);
//   }, error => {
//     console.log(error);

//   })
// }

// optenerJugador(){


// //   this.jugadorService.optenerJugador().subscribe(data => {
// //     this.jugadores=data
// //     console.log(this.jugadores+"jugadores------------")
// //   }, error => {
// //     console.log(error);

// //   })
// }

// obtenerMazo(){
// this.mazoService.optenerMazo().subscribe(data => {
//   this.mazos.push(data);

//   this.mazos.forEach((mazo)=>{
//     // recirrer mazo dentro de barajas
//     mazo.baraja.forEach((mazo)=>{
//        this.barajas.push(mazo)
      
//      console.log(mazo.valor+"este es el valor")
//      console.log(mazo.uri+" esta la uri "+mazo.nombre)

//     })
//   })

//   console.log(this.mazos)
// }, error => {
//   console.log(error);

// })
// }


// obtenerTablero(){
// this.tableroService.optenerTablero().subscribe(data => {
//   this.tableros = data;
   
//   console.log(this.tableros+" este es el tablero")
// }, error => {
//   console.log(error);

// })
// }

// optenerGanadorRonda(){
// this.tableros.forEach((tablero)=>{
//  this.rondaTablero = tablero.ronda;
// })

// this.juegos.forEach((juego)=>{
//   this.idjuego = juego.id
// })

// this.tableroService.optenerGanadorRonda(this.rondaTablero,  this.idjuego ).subscribe(data => {
//   this.tableros = data;
   
//   console.log(this.tableros+" este es el tablero")
// }, error => {
//   console.log(error);

// })
// }

apostarCarta(idjugador1: any, idcarta1: any,  uricarta1: any, idjuego1: any){

  const APUESTA: Tablero = {
    idjugador: idjugador1,
    idcarta: idcarta1,
    uri: uricarta1,
    ronda: "1",
    idJuego: idjuego1
  }
  this.tableroService.ponerApuesta(APUESTA).subscribe(data => {
    this.console.log(APUESTA+"esta es la apuesta del sala")
  }, error => {
    console.log(error);
  })

}

}
