import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Artist } from '../model/artist.model';

@Component({
  selector: 'app-update-artist',
  templateUrl: './update-artist.component.html',
  styles: ``
})
export class UpdateArtistComponent implements OnInit {

  @Input()
  artist! : Artist;

  @Input()
  ajout! : boolean;

  @Output()
  artistUpdated = new EventEmitter<Artist>();
  constructor() { }

  ngOnInit(): void {
  }
  saveArtist() {
    this.artistUpdated.emit(this.artist);
  }

}
