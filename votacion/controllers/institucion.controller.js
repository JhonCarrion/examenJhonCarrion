'use strict'
const institucion = require('../models/institucion.model');
const junta = require('../models/junta.model');

//Simple version, without validation or sanitation
exports.test = function (req, res) {
    res.send('Greetings from the Test controller!');
};
//get all labs
exports.institucion_all = function (req, res) {
    institucion.find({}, function (err, institucion) {
        if (err) return next(err);
        res.send(institucion);
    })
};
//create new institucion
exports.institucion_create = function (req, res, next) {
    let institucion = new institucion({
        nombre: req.body.nombre,
        direccion: req.body.direccion,
        provincia: req.body.provincia,
        canton: req.body.canton,
        parroquia: req.body.parroquia,
        zona: req.body.zona
    });

    institucion.save(function (err, saved) {
        if (err) {
            return next(err);
        }
        for(var i=0; i<req.body.juntasm; i++){
            let junta = new junta({
                numero: i,
                tipo: "Masculino",
                institucion: saved
            });

            junta.save(function (err) {
                if (err) {
                    return next(err);
                }
                res.send('junta Created successfully');
            });
        }
        for(var i=0; i<req.body.juntasf; i++){
            let junta = new junta({
                numero: i,
                tipo: "Femenino",
                institucion: saved

            });

            junta.save(function (err) {
                if (err) {
                    return next(err);
                }
                res.send('junta Created successfully');
            });
        }

        res.send('institucion Created successfully');
    });
};
//get a institucion
exports.institucion_details = function (req, res, next) {
    institucion.findById(req.params.id, function (err, institucion) {
        if (err) return next(err);
        res.send(institucion);
    })
};
//update a institucion
exports.institucion_update = function (req, res) {
    institucion.findByIdAndUpdate(req.params.id, {$set: req.body}, function (err, institucion) {
        if (err) return next(err);
        res.send('institucion udpated.');
    });
};
//delete a institucion
exports.institucion_delete = function (req, res) {
    institucion.findByIdAndRemove(req.params.id, function (err) {
        if (err) return next(err);
        res.send('Deleted institucion successfully!');
    })
};