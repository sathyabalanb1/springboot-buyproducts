
$(document).ready(function () {
    $('#submitButton').click(function(event) {
        event.preventDefault(); // Prevent form submission
        
        var selectedProducts = [];

        $('input[type="checkbox"]:checked').each(function() {
            var $row = $(this).closest('tr');
            var productData = {
                productname: $row.find('input[name^="productname"]').val(),
                productprice: $row.find('input[name^="productprice"]').val(),
                availablequantity: $row.find('input[name^="productquantity"]').val(),
                requiredquantity: $row.find('input[type="number"]').val(),
                productid: $(this).val(),
                customerid: $row.find('input[name^="customerid"]').val(),
            };
            selectedProducts.push(productData);
            
        });
        
        console.log(selectedProducts);
    });
    
    $.ajax({
            url: '/makeorder', // Specify the URL to which you want to send the data
            method: 'POST', // Specify the HTTP method
            data: JSON.stringify(selectedProducts),
            dataType: 'json', // Convert selectedProducts array to JSON string
            contentType: 'application/json', // Set content type to JSON
            success: function(response) {
                // Handle successful response
                console.log('Success:', response);
            },
            error: function(xhr, status, error) {
                // Handle error
                console.error('Error:', error);
            }
        });
    
});
