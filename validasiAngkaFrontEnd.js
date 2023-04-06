const inputAngka = document.getElementById('inputAngka');
const btnSegitiga = document.getElementById('btnSegitiga');
const btnGanjil = document.getElementById('btnGanjil');
const btnPrima = document.getElementById('btnPrima');
contt hasil = document.getElementById('hasil');

btnSegitiga.addEventListener('click',function()){
    const angka = inputAngka.value;
    if (isValidAngka(angka)){
        fetch('.generateSegitiga?angka=' + angka)
        .then(response => response.json())
        .then(data = > {
            hasil.innerHTML = data;
        });
    }else{
        alert('Error: data harus berupa angka positif')
    }
}

btnGanjil.addEventListener('click',function()){
    const angka = inputAngka.value;
    if (isValidAngka(angka)){
        fetch('.generateGanjil?angka=' + angka)
        .then(response => response.json())
        .then(data = > {
            hasil.innerHTML = data;
        });
    }else{
        alert('Error: data harus berupa angka positif')
    }
}

btnPrima.addEventListener('click',function()){
    const angka = inputAngka.value;
    if (isValidAngka(angka)){
        fetch('.generatePrima?angka=' + angka)
        .then(response => response.json())
        .then(data = > {
            hasil.innerHTML = data;
        });
    }else{
        alert('Error: data harus berupa angka positif')
    }
}

function isValidAngka(angka){
    return angka && parseInt(angka) > 0;
}