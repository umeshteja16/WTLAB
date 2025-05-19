let cart = [];

function addToCart(name, price) {
    const item = cart.find(book => book.name === name);
    if (item) {
        item.quantity++;
    } else {
        cart.push({ name, price, quantity: 1 });
    }
    updateCart();
}

function removeFromCart(name) {
    const item = cart.find(book => book.name === name);
    if (item) {
        item.quantity--;
        if (item.quantity === 0) {
            cart = cart.filter(book => book.name !== name);
        }
    }
    updateCart();
}


function updateCart() {
    const cartItems = document.getElementById('cart-items');
    const cartTotal = document.getElementById('cart-total');
    cartItems.innerHTML = '';
    let total = 0;

    cart.forEach(book => {
        const li = document.createElement('li');
        li.textContent = `${book.name} - $${book.price} x ${book.quantity}`;
        
        const removeButton = document.createElement('button');
        removeButton.textContent = 'Remove';
        removeButton.onclick = () => removeFromCart(book.name);
        li.appendChild(removeButton);
        
        cartItems.appendChild(li);
        total += book.price * book.quantity;
    });

    cartTotal.textContent = total.toFixed(2);
}
