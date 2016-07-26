/*
 * This file is part of KeyAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016 Epic Planet Minecraft Server <http://epicpla.net>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.epicpla.keyapi;

/**
 * Represents keys which can be detected.
 *
 * @author Final Child
 * @since 1.0
 */
public enum Key {

    /**
     * Drop Selected Item (Default: Q)
     * Cannot be detected if there is no item in the player's main hand.
     */
    DROP,

    /**
     * Open/Close Inventory (Default: E)
     * Even if the event is cancelled, the player may see the inventory for a short moment.
     */
    INVENTORY,

    /**
     * Swap Item In Hands (Default: F)
     * Can be detected even if there is no item in the player's both hands.
     */
    SWAPHANDS,

    /**
     * Sneak (Default: LSHIFT)
     * Even if the event is cancelled, the client can sneak.
     * However the server will not consider the player sneaking, and other players will not see the player is sneaking. Vice versa.
     * Force-place(SNEAK+USE) will be changed to normal USE if sneaking is cancelled and the client keeps sneaking. Vice versa.
     * Dismounting will not be considered sneaking. But normally the player keeps pressing LSHIFT for a short moment after dismounting, which is considered sneaking.
     */
    SNEAK,
    SNEAK_OFF,

    /**
     * Dismount (Default: LSHIFT)
     */
    DISMOUNT;


}
