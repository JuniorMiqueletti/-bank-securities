$('#dailogExclusionConfirmationModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var secCodigo = button.data('codigo');
	var secDescription = button.data('description');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('base-url');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + secCodigo);
	
	modal.find('.modal-body span').html('Do you right in Delete the <strong>' + secDescription + '</strong>?');
});

$('#sandbox-container input').datepicker({
});

$(function() {
    $('[rel="tooltip"]').tooltip();

    $('.js-currency').maskMoney({decimal: '.', thousands: ',', allowZero: true});

    $('.js-update-status').on('click', function(){
        event.preventDefault();
        console.log("clicked");

        var buttonReceive = $(event.currentTarget);
        var urlReceive    = buttonReceive.attr('href');

        console.log(urlReceive);

        var response = $.ajax({
            url: urlReceive,
            type: 'PUT'
        });

        response.done(function(e){
          console.log('done');
            var codigo = buttonReceive.attr('data-codigo');
          console.log(codigo);
            $('[data-role=' + codigo + ']').html('<span class="label label-success">' + e + '</span>');
            buttonReceive.hide();

        });

        response.fail(function(e){
            console.log(e);
            alert('Error!')
        });

    });

});