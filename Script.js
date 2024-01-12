const products = [
    { name: "T-shirt", price: 20, image: "image1.jpeg" },
    { name: "Jeans", price: 40, image: "image2.jpeg" },
    { name: "Robe", price: 35, image: "image3.jpeg" },
    { name: "Chaussures", price: 50, image: "image4.jpeg" },
    { name: "Casquette", price: 15, image: "image5.jpeg" },
    { name: "Sac à dos", price: 30, image: "image6.jpeg" },
    // Ajoutez d'autres produits ici
];

function displayProducts() {
    const productsContainer = document.getElementById("products-container");

    products.forEach(product => {
        const productDiv = document.createElement("div");
        productDiv.classList.add("product");

        const productImage = document.createElement("img");
        productImage.src = product.image;
        productImage.alt = product.name;

        const productName = document.createElement("p");
        productName.textContent = product.name;

        const productPrice = document.createElement("p");
        productPrice.textContent = `$${product.price}`;

        productDiv.appendChild(productImage);
        productDiv.appendChild(productName);
        productDiv.appendChild(productPrice);

        productsContainer.appendChild(productDiv);

        // Ajouter un événement de clic pour sélectionner le produit
        productDiv.addEventListener("click", () => selectProduct(product));

        // Remplir la liste déroulante dans la page "achat.html"
        const productList = document.getElementById("product-list");
        const option = document.createElement("option");
        option.value = product.name;
        option.textContent = product.name;
        productList.appendChild(option);
    });
}

function selectProduct(product) {
    const selectedProduct = document.getElementById("selected-product");
    selectedProduct.textContent = `Produit sélectionné: ${product.name} - Prix: $${product.price}`;
}

window.onload = displayProducts;
