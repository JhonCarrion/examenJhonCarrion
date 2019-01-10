require('./junta.model');

var mongoose = require('mongoose');
var Type_Laboratory = mongoose.model('Junta');

var Schema = mongoose.Schema;

var persona = new Schema({
    cedula: {
        type: String,
        required: true
    },
    nombre: {
        type: String,
        required: true
    },
    junta: {
        type: mongoose.Schema.Types.ObjectId, 
        ref: 'Junta'
    },
    created: { 
        type: Date,
        default: Date.now
    }
});

module.exports = mongoose.model('Persona', persona);