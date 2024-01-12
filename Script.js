// Exemple de produits (ajoutez autant que nécessaire)
const products = [
    { name: "T-shirt", price: 20, image: "tshirt.jpg" },
    { name: "Jeans", price: 40, image: "jeans.jpg" },
    // Ajoutez d'autres produits ici
];

// Fonction pour afficher les produits sur la page "produits.html"
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

        // Ajouter un événement de clic pour sélectionner le produit
        productDiv.addEventListener("click", () => selectProduct(product));

        productDiv.appendChild(productImage);
        productDiv.appendChild(productName);
        productDiv.appendChild(productPrice);

        productsContainer.appendChild(productDiv);
    });
}

// Fonction pour sélectionner un produit sur la page "achat.html"
function selectProduct(product) {
    const selectedProduct = document.getElementById("selected-product");
    selectedProduct.textContent = `Produit sélectionné: ${product.name} - Prix: $${product.price}`;
}

// Appel de la fonction pour afficher les produits lors du chargement de la page
window.onload = displayProducts;
