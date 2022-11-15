// function editCart(cartItemId, buyCount) {
//     window.location.href = "cart.do?operate=editCart&cartItemId=" + cartItemId + "&buyCount=" + buyCount;
// }

window.onload = function() {
    let vm = new Vue({
        el: "#cart_div",
        data: {
            cart: {}
        },
        methods: {
            getCart() {
                axios({
                    method: "post",
                    url: "cart.do",
                    params: {
                        operate: "cartInfo"
                    }
                }).then(res => {
                    this.cart = res.data;
                }).catch(err => {

                })
            },
            editCart(cartItemId, buyCount) {
                axios({
                    method: "post",
                    url: "cart.do",
                    params: {
                        operate: "editCart",
                        cartItemId: cartItemId,
                        buyCount: buyCount
                    }
                }).then(res => {
                    this.getCart();
                }).catch(err => {

                })
            }
        },
        mounted: function() {
            this.getCart();
        }
    });
}