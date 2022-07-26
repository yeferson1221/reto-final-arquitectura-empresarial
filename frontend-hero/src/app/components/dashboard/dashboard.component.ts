import { Component, OnInit } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { Router } from '@angular/router';
import { Carta } from '../models/carta';
import { CartaService } from '../../services/cartas.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  dataUser: any;
  cartas: Carta[] =[];

  constructor(
      private afAuth: AngularFireAuth,
      private cartaService: CartaService,
      private router: Router
      ) { }

  ngOnInit(): void {
    this.afAuth.currentUser.then(user => {
      if(user && user.emailVerified) {
        this.dataUser = user;
        console.log(user)
      } else {
        this.router.navigate(['/login']);
      }
    })
    this.obtenerCarta()
  }

   logOut() {
   this.afAuth.signOut().then(() => this.router.navigate(['/login']));
   }


   obtenerCarta(){
    this.cartaService.optenerCarta().subscribe(data => {
      this.cartas = data;
      console.log(this.cartas+"estas son las cartas")
    }, error => {
      console.log(error);
    
    })
  }

}
