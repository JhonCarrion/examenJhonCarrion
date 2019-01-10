'use strict'
const persona = require('../models/persona.model');

//Simple version, without validation or sanitation
exports.test = function (req, res) {
    res.send('Greetings from the Test controller!');
};
//get all labs
exports.persona_all = function (req, res) {
    persona.find({}, function (err, persona) {
        if (err) return next(err);
        res.send(persona);
    })
};
//create new persona
exports.persona_create = function (req, res) {
    let persona = new persona({
        cedula: req.body.cedula,
        nombre: req.body.nombre
    });

    persona.save(function (err) {
        if (err) {
            return next(err);
        }
        res.send('persona Created successfully');
    });
};
//get a persona
exports.persona_details = function (req, res) {
    persona.find({'cedula': req.params.id}, function (err, persona) {
        if (err) return next(err);
        res.send(persona);
    })
};
//update a persona
exports.persona_update = function (req, res) {
    persona.findByIdAndUpdate(req.params.id, {$set: req.body}, function (err, persona) {
        if (err) return next(err);
        res.send('persona udpated.');
    });
};
//delete a persona
exports.persona_delete = function (req, res) {
    persona.findByIdAndRemove(req.params.id, function (err) {
        if (err) return next(err);
        res.send('Deleted persona successfully!');
    })
};