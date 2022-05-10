const cards=document.querySelectorAll('.card');
let carta_virada=false;
let primeira_carta,segunda_carta;
let bloquear=false;
function flipCard(){
    if(bloquear) return;

    this.classList.toggle('flip');
    if(!carta_virada){
        carta_virada=true;
        primeira_carta=this;
        return;
    }
    segunda_carta=this;
    carta_virada=false;
    comparar();
}

function comparar(){
    if(primeira_carta.dataset.card===segunda_carta.dataset.card && primeira_carta.style.order!==segunda_cartastyle.order){
        desativar_carta();
        return;
    }
    bloquear=true; 
    desvirar_carta(); 
    
}

(function embaralhar(){
    cards.forEach((card)=>{
        let randonPosition=Math.floor(Math.random()*12);
        card.style.order=randonPosition;
    })
})();

function desativar_carta(){
    primeira_carta.removeEventListener('click',flipCard);
    segunda_carta.removeEventListener('click',flipCard);
    bloquear=false;
}

function desvirar_carta(){
    setTimeout(() => {
        primeira_carta.classList.remove('flip');
        segunda_carta.classList.remove('flip');
        bloquear=false; 
    },1500);
    
}


cards.forEach((card)=>{
    card.addEventListener('click',flipCard)
})