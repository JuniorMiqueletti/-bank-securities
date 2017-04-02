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
    $('.js-currency').maskMoney({decimal: '.', thousands: ',', allowZero: true});
});