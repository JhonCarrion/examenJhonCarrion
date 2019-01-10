var express = require('express');
var router = express.Router();

const junta_controller = require('../controllers/junta.controller');

/* GET home page. */
router.get('/test', junta_controller.test);
router.get('/', junta_controller.junta_all);
router.get('/:id', junta_controller.junta_details);
router.post('/create', junta_controller.junta_create);
router.put('/:id/update', junta_controller.junta_update);
router.delete('/:id/delete', junta_controller.junta_update);

module.exports = router;