var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var institucion = new Schema({
    _id:mongoose.Schema.Types.ObjectId,
    nombre: {
        type: String,
        required: true
    },
    direccion: {
        type: String,
        required: true
    },
    provincia:{
        type: String, 
        require: true
    },
    canton: {
        type: String,
        require: true
    },
    parroquia: {
        type: String,
        require: true
    },
    zona: {
        type: String,
        default: true
    },
    created: { 
        type: Date,
        default: Date.now
    }
});

module.exports = mongoose.model('Institucion', institucion);