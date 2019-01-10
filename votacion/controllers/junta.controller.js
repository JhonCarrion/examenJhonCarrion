'use strict'
const junta = require('../models/junta.model');

//Simple version, without validation or sanitation
exports.test = function (req, res) {
    res.send('Greetings from the Test controller!');
};
//get all labs
exports.junta_all = function (req, res) {
    junta.find({}, function (err, junta) {
        if (err) return next(err);
        res.send(junta);
    })
};
//create new junta
exports.junta_create = function (req, res) {
    let junta = new junta({
        numero: req.body.numero,
        tipo: req.body.tipo
    });

    junta.save(function (err) {
        if (err) {
            return next(err);
        }
        res.send('junta Created successfully');
    });
};
//get a junta
exports.junta_details = function (req, res) {
    junta.findById(req.params.id, function (err, junta) {
        if (err) return next(err);
        res.send(junta);
    })
};
//update a junta
exports.junta_update = function (req, res) {
    junta.findByIdAndUpdate(req.params.id, {$set: req.body}, function (err, junta) {
        if (err) return next(err);
        res.send('junta udpated.');
    });
};
//delete a junta
exports.junta_delete = function (req, res) {
    junta.findByIdAndRemove(req.params.id, function (err) {
        if (err) return next(err);
        res.send('Deleted junta successfully!');
    })
};