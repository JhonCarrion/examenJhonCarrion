var express = require('express');
var router = express.Router();

const persona_controller = require('../controllers/persona.controller');

/* GET home page. */
router.get('/test', persona_controller.test);
router.get('/', persona_controller.persona_all);
router.get('/:id', persona_controller.persona_details);
router.post('/create', persona_controller.persona_create);
router.put('/:id/update', persona_controller.persona_update);
router.delete('/:id/delete', persona_controller.persona_update);

module.exports = router;