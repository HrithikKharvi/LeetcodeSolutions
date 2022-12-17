/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let finalString = ""
    
    for(let i=0; i< s.length; i++){
        let longString = "";
        
            longString = checkForPal(s, i,i+1);
            if(longString.length > finalString.length) finalString = longString;

            longString = checkForPal(s, i, i);
            if(longString.length > finalString.length) finalString = longString;

        
    }
    
    if(s.length == 2 && finalString.length <1) return s[0];
    
    return finalString;
    
};

function checkForPal(currentString, p1, p2){
    
   let longStr = "";
    
    while(p1>=0 && p2<currentString.length){
        if(currentString[p1] == currentString[p2]) {
            longStr = currentString.slice(p1,p2+1);
            p1--;
            p2++;
        }
        else return longStr;
    }
    
    return longStr;
    
}
