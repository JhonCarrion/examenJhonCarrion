var express = require('express');
var router = express.Router();

const institucion_controller = require('../controllers/institucion.controller');

/* GET home page. */
router.get('/test', institucion_controller.test);
router.get('/', institucion_controller.institucion_all);
router.get('/:id', institucion_controller.institucion_details);
router.post('/create', institucion_controller.institucion_create);
router.put('/:id/update', institucion_controller.institucion_update);
router.delete('/:id/delete', institucion_controller.institucion_update);

module.exports = router;