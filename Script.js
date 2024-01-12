const products = [
    { name: "T-shirt", price: 20, image: "tshirt.jpg" },
    { name: "Jeans", price: 40, image: "jeans.jpg" },
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
    });
}

function selectProduct(product) {
    const selectedProduct = document.getElementById("selected-product");
    selectedProduct.textContent = `Produit sélectionné: ${product.name} - Prix: $${product.price}`;
}

window.onload = displayProducts;
