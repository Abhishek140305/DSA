var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== 'function')
        return false;
    return Object(obj) instanceof classFunction;
};