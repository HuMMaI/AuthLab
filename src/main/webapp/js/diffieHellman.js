const MIN = 1;
const MAX = 100;

let key = 0;

window.onload = (event) => {
    event.preventDefault();
    keyGen();
}

let keyGen = () => {
    let g = randomNumber();
    let p = randomNumber();
    let a = randomNumber();

    let numberMod = numberModGen(g, p, a);

    let diffieHellmanData = {
        g,
        p,
        numberMod
    };

    $.ajax({
        url: "/dh",
        type: "GET",
        data: diffieHellmanData
    })
        .done(function (data, textStatus, xhr) {
            if (xhr.status === 200) {
                key = Math.floor(Math.pow(data, a) % p);
            }
        });

    console.log(key);
};

let randomNumber = () => {
    return Math.floor(Math.random() * (MAX - MIN) + MIN);
};

let numberModGen = (g, p, a) => {
    let pow = Math.pow(g, a);
    return Math.floor(pow % p);
};
