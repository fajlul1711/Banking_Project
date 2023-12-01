// JavaScript for a simple image slider
const images = ['image/airtical11.png', 'image/airtical2.png', 'image/airtical3.png'];
let currentImage = 0;

function changeImage() {
    currentImage = (currentImage + 1) % images.length;
   
//    const img= document.getElementById('article')
//    img.setAttribute('src','${images[currentImage]}')

    document.getElementById('article').style.backgroundImage = `url(${images[currentImage]})`;
}

// Change the image every 5 seconds
setInterval(changeImage, 3000);

// Initial image change
changeImage();